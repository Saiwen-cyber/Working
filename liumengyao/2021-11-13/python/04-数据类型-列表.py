"""
(3) 列表
    使用[] 来标识
    <class 'list'>
    是常用的存储单元
        可以有增删改查的操作
"""

# 1. 创建列表
# 创建方法一
list_1 = list()
print(list_1)
print(type(list_1))

# 创建方法二
list_2 = []
print(list_2)
print(type(list_2))

# 创建一个有内容的列表
list_3 = ['张三', '李四', '王五', '刘六', 'Arkin']
# 查看元素个数 len()
print(len(list_3))  # 5


# 2.查找元素
print(list_3[1])
# 列表进行范围提取 返回的还是列表
print(list_3[-2:])   # ['刘六', 'Arkin']


# 3.更改元素
# 先定位查找到这个位置, 再重新赋值
list_3[1] = '张发财'
print(list_3)   # ['张三', '张发财', '王五', '刘六', 'Arkin']
# 批量更改
list_3[0:2] = ['李白', '吕布']
print(list_3)   # ['李白', '吕布', '王五', '刘六', 'Arkin']
list_3[0:2] = '李白'
print(list_3)   # ['李', '白', '王五', '刘六', 'Arkin']
list_3[0:2] = '李'  #尽量等号左右元素个数相等
print(list_3)   # ['李', '王五', '刘六', 'Arkin']


# 4.添加元素
# (1) append(需要添加的元素)   #只能添加到列表最后
list_3.append('孙悟空')
list_3.append(1000)
list_3.append(True)
list_3.append([1,2,3])
print(list_3)

# (2) insert(添加的位置, 添加的元素)  #可以在任意位置添加
list_3.insert(1,'钟馗')
print(list_3)

# (3) extend(需要填入可遍历内容)   #同时添加多个元素
list_4 = [[], 123, True]
list_3.extend(list_4)
print(list_3)

# (4) +  拼接
list_5 = list_3 + ['马可波罗', '鲁班', '伽罗']
print(list_5)


# 5.删除
# (1) remove(需要删除的元素)  # 根据列表的元素进行删除
list_3.remove('李')
print(list_3)

# (2) del    # 根据列表的下标进行删除
del list_3[-6]
print(list_3)

# (3) list.clear()   # 清空
# (4) del list_3   # 默认删除整个列表 让内存中没有list_3这个变量名


# 6.排序
list_5 = [4,7,3,2,5,1,8,9]
list_5.sort()     # 默认从小到大排列
print(list_5)

list_5.reverse()    #反转列表
print(list_5)

list_5.sort(reverse=True)  # 从大到小  reverse控制排序顺序
print(list_5)

# 字符串根据英文单词首字母进行排序 如果相同 对比后面的字母
list_6 = ['hello', 'world', 'apple', 'yellow', 'red']
list_6.sort()
print(list_6)

# 中文排序
list_7 = ['你', '我', '她', '啊']
list_7.sort()
print(list_7)