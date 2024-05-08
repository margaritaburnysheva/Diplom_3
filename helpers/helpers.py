import string
import random


class Helpers:
    def generate_random_string(self, length):
        letters = string.ascii_lowercase
        random_string = ''.join(random.choice(letters) for i in range(length))
        return random_string

    def generate_random_pass(self):
        email = self.generate_random_string(10) + '@yandex.ru'
        password = self.generate_random_string(10)
        name = self.generate_random_string(10)
        user_pass = {
            "email": email,
            "password": password,
            "name": name
        }
        return user_pass
