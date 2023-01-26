import requests
import json
import os

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
