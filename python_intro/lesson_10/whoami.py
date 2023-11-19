import pandas as pd
import random
lst = ['robot'] * 10
lst += ['human'] * 10
random.shuffle(lst)
robots = [1 if who == "robot" else 0 for who in lst]
humans = [1 if who == "human" else 0 for who in lst]

data = pd.DataFrame({'human': humans, 'robot': robots})
data.head(20)

# data = pd.DataFrame({'whoAmI':lst})
# pd.get_dummies(data['whoAmI'])
# data.head(20)