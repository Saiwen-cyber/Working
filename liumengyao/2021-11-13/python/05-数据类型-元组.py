"""
元组
    常用的存储单元
    () <class 'tuple'>

    特点:
        元组内的元素是不可以改变的
"""

# 1.创建
# (1) 方法一
tuple_1 = tuple()
print(tuple_1)
print(type(tuple_1))

# (2) 方法二
tuple_2 = ()
print(tuple_2)
print(type(tuple_2))


# 2.查找
tuple_3 = ('貂蝉', '杨玉环', '王昭君', '西施', '李瑞鑫')
print(tuple_3[0])
print(tuple_3[0:3])  # 元组范围提取 返回的也是元组类型

# 在这个元素中是 不能更改、删除、添加


# 3.转换类型
# (1) 元组转化成列表
list_1 = list(tuple_3)
print(list_1)
list_1.append('妲己')
print(list_1)

# (2) 列表转化成元组
tuple_3 = tuple(list_1)
print(tuple_3)


# 4.进行拼接
res = ('唐伯虎',)  #元组在只有一个元素时，后面要加一个英文逗号 否则会被认定为字符串
print(res)
print(type(res))
tuple_3 += ('唐伯虎',)
print(tuple_3)
