import requests
import json
import os
# Инструкция: Ссылка в виде github.com/tensorflow/tensorflow Вписывается github.com/*********/tensorflow (то что под звездачками из ссылки на реп) - tensorflow если ссылка ввиде github.com/nodejs/node (вписывается "nodejs") и получаем информацию
url = "https://api.github.com/users/"
# repo_name = "tensorflow"
repo_name = str(input("Введите название репозитория: "))

resp = requests.get(url + repo_name).json()

result = {'company': resp.get("company"),
          'created_at': resp.get("created_at"),
          'email': resp.get("email"),
          'id': resp.get("id"),
          'name': resp.get("name"),
          'url': resp.get("url")
          }
path_to_script = os.path.dirname(os.path.realpath(__file__))
new_file_path = os.path.join(path_to_script, "data_file.json")

with open(new_file_path, "w") as write_file:
    json.dump(result, write_file, indent=4)
