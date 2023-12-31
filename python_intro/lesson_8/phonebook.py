def show_menu():
	print('1. Распечатать справочник',
	'2. Найти телефон по фамилии',
	'3. Изменить номер телефона',
	'4. Удалить запись',
	'5. Найти абонента по номеру телефона',
	'6. Добавить абонента в справочник',
	'99. Копирование данных из одного файла в другой по номеру строки',
	'7. Закончить работу', sep = '\n')
	choice=int(input())
	return choice

def work_with_phonebook():
	choice=show_menu()
	phone_book = read_txt('phonebook.txt')

	while (choice!=7):

		if choice==1:
			print_result(phone_book)
		elif choice==2:
			last_name=input('lastname ')
			print(find_by_lastname(phone_book,last_name))
		elif choice==3:
			last_name=input('lastname ')
			new_number=input('new number ')
			print(change_number(phone_book,last_name,new_number))
		elif choice==4:
			lastname=input('lastname ')
			print(delete_by_lastname(phone_book,lastname))
		elif choice==5:
			number=input('number ')
			print(find_by_number(phone_book,number))
		elif choice==6:
			user_data=input('Введите, отделяя запятой: Фамилия, Имя, Телефон, Описание \n')
			add_user(phone_book,user_data)
			write_txt('phonebook.txt',phone_book)
		elif choice==99:
			string_number=int(input('Номер строки (шапка не в счёт): '))
			if 0 < string_number <= len(phone_book) + 1:
				filename=input('Укажите название файла ') 
				write_txt(filename,get_string(phone_book,string_number))
			else: print('Нет такой строки')
						
		choice=show_menu()		

def print_result(phone_book):
	for key in phone_book[0].keys():
		print(key,end=' ')
	print()
	for entry in phone_book:
		for value in entry.values():
			print(value,end=' ')
	print()

def find_by_lastname(phone_book,last_name):
	for entry in phone_book:
		for value in entry.values():
			if entry.get('Фамилия',0) == last_name:
				return entry.get('Телефон')
	return('Такой фамилии нет')


def change_number(phone_book,last_name,new_number):
	for entry in phone_book:
		for value in entry.values():
			if entry.get('Фамилия',0) == last_name:
				entry["Телефон"] = new_number
				filename = input('Save as: ')
				write_txt(filename,phone_book)
				return 'Телефонный номер изменён'
	return('Такой фамилии нет')


def delete_by_lastname(phone_book,last_name):
	for entry in phone_book:
		for value in entry.values():
			if entry.get('Фамилия',0) == last_name:
				phone_book.pop(phone_book.index(entry))
				filename = input('Save as: ')
				write_txt(filename,phone_book)
				return('Запись удалена')
	return('Такой фамилии нет')


def find_by_number(phone_book,number):
	entry_out = ''
	for entry in phone_book:
		for value in entry.values():
			if entry.get('Телефон',0) == number:
				for value in entry.values():
					entry_out += value + " "
				return entry_out
	return('Телефон не найден')

def add_user(phone_book,user_data):
	fields=['Фамилия', 'Имя', 'Телефон', 'Описание']
	new_record = dict(zip(fields, user_data.split(',')))
	phone_book.append(new_record)
	print('Запись добавлена')
	return phone_book

def get_string(phone_book,string_number):
	finded_string = []
	finded_string.append(phone_book[string_number-1])
	return finded_string


def read_txt(filename):
	phone_book=[]
	fields=['Фамилия', 'Имя', 'Телефон', 'Описание']

	with open(filename,'r', encoding='utf-8') as phb:
		for line in phb:
			record = dict(zip(fields, line.split(',')))
			phone_book.append(record)
	return phone_book

def write_txt(filename , phone_book):

	with open(filename,'w',encoding='utf-8') as phout:

		for i in range(len(phone_book)):
			s=''
			for v in phone_book[i].values():
				s+=v+','
			phout.write(f'{s[:-1]}\n')


work_with_phonebook()