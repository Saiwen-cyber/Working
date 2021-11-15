"""
(2) 字符串:
    单引号: 保存单行的数据
    双引号: 保存单行的数据
    三引号: 保存多行的数据

    索引下标取值:
        i.单个字符提取
            str[下标数值]
            正序提取下标值: 0、1、2...
            倒序提取下标值: -1、-2、-3...

        ii.范围提取
            格式: str[ 起始下标 : 结束下标 ]
            范围: [起始, 结束)  (左闭右开)
            补充: 起始下标不写则默认从0开始; 结束下标不写则默认到最后一个。

        iii.步长step
            格式: str[::step]  跳着输出 跳step
            注意: step符号控制正反, step为负值时, 倒序输出(step=-1时，把str反过来)
"""

# 字符串:
name = 'RICH'
name = "RICH"
name = """RICH"""
name = '''RICH'''

str_1 = """
心动因你存在
是对你满怀期待
"""
print(str_1)

str_num = "1234567"
print(str_num)
print(type(str_num))


# 索引下标: 单个字符提取
str_2 = "键盘敲烂, 月入过万"
print('str_2: ' + str_2)
print('str_2 索引值为2的字符是: ' + str_2[2])

# 索引下标: 范围提取
str_3 = "要做你的专属美梦制造机"
print('str_3: ' + str_3)
print('str_3 索引[3,7)的字符为: ' + str_3[3: 7])
print(str_3[:])  # 打印所有内容
print(str_3[::]) # 打印所有内容
print(str_3[-5:]) # 美梦制造机

# 步长 step
print(str_3[::3])  # 跳着输出
print(str_3[::-1]) # 如果是负值,则是倒序跳着输出
res = str_3[1:4]   # 做你的
print(res[::-1])   # 的你做