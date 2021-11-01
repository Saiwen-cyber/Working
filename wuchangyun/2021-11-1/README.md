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
    return {
        allRecommend,
        setAllRecommend
    }
}
export default createModel(useApp) // 将数据导出  可以理解成将数据广播 谁想用然后引入就行
```

暂时整个主页组件结构

```
-Recommend
---RecomTab
-----Tab
---SongListRecom
-----CardList
--------Transition
```

------

```
// Recommend
```

