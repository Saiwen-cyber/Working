## 通过向后台请求数据渲染到前端页面上

先封装一下请求接口数据的方法

> 使用axios进行封装

```tsx
// request.ts
import axios from "axios"
const instance = axios.create({
    baseURL:
    // 这儿是判断后台是本地服务还是已经部署的服务，请求的地址是不一样
    process.env.NODE_ENV === 'production' ? 'http://***':'http://localhost:3333/api',
    headers:{
        /*
        * 'Content-Type' Accept Connection
        */
    },
    transformRequest:[
        data =>{
            if(!(data instanceof FormData)){
                data = JSON.stringify(data)
            }
            return data;
        }
    ]
})

// axios全局设置网络超时
instance.defaults.timeout = 10000

// http request 拦截器
instance.interceptors.request.use(
    async config =>{
        return config
    },
    err=>{
        return Promise.reject(err)
    }
)

// http response 拦截器
instance.interceptors.response.use(
    response =>{
        return response
    },
    err => {
        return Promise.reject(error.response.status) // 返回接口错误信息
    }
)
export default instance
```

已经封装好了request方法

```tsx
import request from 'request.js'


// 获取首页推荐
export const getRecommend = () => request({method:'GET',url:`/getRecommend`})

```

使用hox将状态提升 达到共享数据的目的

```tsx
// useRecom.ts

import {createModel} from "hox" // 先引入hox

const useApp = () =>{
    // getRecommend 请求数据 这是封装的接口请求函数
    const [allRecommend,setAllRecommend] = useState<Recommend>()
    const [active,setActive] = useState<string>('0')
    
    return {
        allRecommend,
        setAllRecommend,
        active,
        setActive
    }
}
export default createModel(useApp) // 将数据导出  可以理解成将数据广播 谁想用然后引入就行
```

暂时整个主页组件结构(由上到下)

```
-Recommend
---RecomTab
-----Tab
---SongListRecom
-----CardList
--------Transition
```

------

## 第一部分：Recommend

```jsx
// Recommend组件

interface RecommenProps {}

const TabMap:any = {
    '0':<SongListRecom />
}

const Recommend : FC<RecommendProps> = props =>{
    const {setAllRecommend,active,setActive} = useRecom()
    const {setSingerTab} = useScroll()
    
    // render完会调用该方法 数据改变会重新执行该方法
    useEffect(()=>{
        fetchiApi()
    },[])
    
     const fetchApi = async () => {
        const {
            data: {response},
        } = await getRecommend()
        setAllRecommend(response) // 将获取的参数保存至allRecommend
    }

    const tabChange = (key: string, label?: string) => {
        setActive(key)
        setSingerTab(key)
    }

    return (
        <div className={styles.container}>
            <RecomTab
                onChange={(key, label) => tabChange(key, label)}
                defaultActiveKey={active}
                activeKey={active}
            />
            {TabMap[active]}
        </div>
    )
}

export default Recommend
```

让我们看看结构

![图片](https://img.cdn.sugarat.top/mdImg/MTYzNTg1OTc1MTM1OA==635859751358)

渲染出来效果

![image-20211102213020622](C:\Users\17256\AppData\Roaming\Typora\typora-user-images\image-20211102213020622.png)

------

## 第二部分：RecomTab以及Tab

```jsx
// RecomTab
interface RecomTabProps {
    onChange:(key:string,label?:string) => void
    defaultActiveKey?:string
    activeKey?:string
}

const RecomTab: FC<RecomTabProps> = ({onChange,defaultActiveKey,activeKey}) =>{
    return (
        <Tab
            data={dataSource} // 这的dataSource来自自定义的常量
            onChange={(key,label) =>{
                onChange(key,label)
            }}
            defaultActiveKey={defaultActiveKey}
            activeKey={activeKey}
        />
    )
}

export default RecomTab
```

```jsx
// Tab
export type DataType = {
    label:string
    key:string
}

export interface TabProps {
    data:DataType[]
    activeKey?:string
    defaultActiveKey?:string
    onSelect?:(key:string,label?:string) => void
    onChange?:(key:string,label?:string) => void
    itemStyle?:React.CSSProperties
}

const Tab: FC<TabProps> = ({
    data,
    defaultActiveKey,
    activeKey,
    onSelect,
    onChange,
    itemStyle
})=>{
    const [active,setActive] = useState<string>(defaultActiveKey|| data[0].key)

    useEffect(() =>{
        console.log(onSelect);
    },[])


    useEffect(() => {
        activeKey && setActive(activeKey)
    },[activeKey])

    useEffect(() =>{
        onChange && onChange(active,data.find(item => item.key === active)?.label)
    },[active])

    const click = (key:string,label?:string) =>{
        onSelect && onSelect(key,label)
        setActive(key)
    }

    // useMemo是React-Hooks的一个hook 返回值是缓存值
    const RenderTab = useMemo(
        () =>data.map(({label,key}) =>{
            return (
                <div
                    key={key}
                    // 通过判断是否选中的标签进行选中和鼠标移入后的渲染
                    className={classNames(styles.item,{
                        [styles.active]:active == key,
                    })}
                    style={itemStyle}
                >
                    <div onClick={()=> click(key,label)}>{label}</div>
                </div>
            )
        }),[data,active]
    )
// 这儿直接渲染返回的缓存值
    return <div className={styles.container}>{RenderTab}</div>
}
export default Tab
```

------

## 第三部分：TabMap[active]

>也就是SongListRecom

```tsx
// SongListRecom
interface SongListRecomProps {}

const SongListRecom:FC<SongListRecomProps> = props =>{
    const history = useHistory()
    const {allRecommend} = useRecom()
    const [recomPlaylist,setRecomPlaylist] = useState<any>([])
    const {setPlaylist,curSong,setCurSong} = usePlayer()

    useEffect(() =>{
        setRecomPlaylist(allRecommend?.recomPlaylist?.data?.v_hot)
    },[allRecommend])

    const fetchApi = async (param:any)=>{
        const {
            data:{
                response:{cdlist},
            },
        } = await getSongListDetail(param)
        setRecomPlaylist(cdlist[0]?.songlist)
        setCurSong(cdlist[0]?.songlist[0]['mid'])
    }

    return (
        <div>
            <CardList
                data={recomPlaylist}
                showListenNum
                onPlay={id=>{
                    fetchApi({disstid:id})
                }}
                onView={id=>{
                    history.push('/SongListDetail',{disstid:id})
                }}
            />
        </div>
    )
}

export default SongListRecom
```

```tsx
// CardList

const CardList :FC<CardListProps> = ({data,size = 8,showListenNum = false,onPlay,onView}) =>{
    const [list,setList] = useState<DataType[]>([])
    const [current,setCurrent]  = useState<number>(1)
    const [show,setShow] = useState<boolean>(false)
    const [toplay,setToplay] = useState<{show:boolean;title:string}>({
        show:false,
        title:''
    })

    const Slice = useCallback((data,cur,size) =>{
        const res = data?.slice((cur-1) * size,cur*size)
        return new Array(size).fill({
            title:'no123',
            cover:'',
        })
            .map((i,index) =>({...i,...res?.[index]}))
    },[])

    useEffect(()=>{
        setList(Slice(data,current,size))
        console.log(data)
    },[data,current])

    const RenderCard = useMemo(
        ()=>
            list?.map(({cover,title,listen_num,content_id},index) =>(
                <div key={index} style={title==='no123' ? {visibility:'hidden'}:{}}>
                    <div
                        className={styles.item}
                        onMouseEnter = {() => {mouseImg(1,title); console.log(title)}}
                        onMouseLeave = {() => mouseImg(0,title)}
                        onClick={() => onView && onView(content_id)}
                    >
                        <Transition
                            classNames="toplayAnim"
                            in={toplay.title === title && toplay.show}
                            timeout={300}
                        >
                            <i
                                className={classNames('iconfont','icon-toplay',styles.toplay)}
                                onClick={e =>{
                                    e.stopPropagation()
                                    onPlay && onPlay(content_id);
                                }}
                            />
                        </Transition>
                        {showListenNum &&(
                            <Transition
                                in={!(toplay.title === title && toplay.show)}
                                timeout={0}
                            >
                                <div className={styles.listen}>
                                    <i className={classNames('iconfont','icon-listen')}/>
                                    {numberFormat(listen_num)}
                                </div>
                            </Transition>
                        )}
                        <img src={cover} alt={title}/>
                    </div>
                    <div onClick={() => onView && onView(content_id)}>{title}</div>
                </div>
            )),[list,toplay]
    )

    const prev = () =>{
        if(current <= 1) return
        setCurrent(pre => pre - 1)
    }

    const next = () =>{
        if(current >= Math.ceil(data?.length/8)) return
        setCurrent(pre => pre + 1)
    }

    const mouse = (type:number) =>{
        setShow(type?true:false)
    }

    const mouseImg = (type:number,title:string) =>{
        setToplay({show:type?true:false,title:type?title:''})
    }

    return (
        <div className={styles.container} onMouseEnter={() => mouse(1)} onMouseLeave={() => mouse(0)}>
            <div className={classNames(styles.icon)}>
                <Transition in={show} animation="zoom-in-right" timeout={500}>
                    <Icon type="icon-left-arrow" onClick={() => prev()} />
                </Transition>
            </div>
            <div className={styles.cardBox}>{RenderCard}</div>
            <div className={classNames(styles.icon,styles.rightIcon)}>
                <Transition in={show} animation="zoom-in-left" timeout={500}>
                    <Icon type="icon-right-arrow" onClick={() => next()} />
                </Transition>
            </div>
        </div>
    )
}

export default CardList
```

