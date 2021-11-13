"""
set
    {}
    特殊的功能
        去重
        并且是一个无序的
"""

# 1.创建方式
set_1 = set()
print(set_1)
print(type(set_1))

set_2 = {'周一', '周二', '周三', '周四', '周五', '周五', '周五'}
print(set_2)


# 2.查找
# set_2[0]   不能查找 没有索引


# 3.删除
set_2.remove('周五')
print(set_2)

res = set_2.pop()
print('弹出的内容是: ', res)   # 随机弹出
print(set_2)


# 4.添加
set_2.add('周六')
print(set_2)   # 添加的位置也是随机的


# 5.更改
set_2.update(['周天'])  #不加[]的话  看作字符串(可迭代内容, 批量添加)   是加入 '周' 和 '天'
# set_2.update(['周天'], ['周八'])
print(set_2)