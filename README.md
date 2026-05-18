<div align="center">

# CustomEnchantTable

![Release](https://img.shields.io/github/v/release/crysscoder/custom-enchant-table?style=flat-square&label=release)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Paper](https://img.shields.io/badge/Paper-1.20.1-2ea44f?style=flat-square)
![Issues](https://img.shields.io/github/issues/crysscoder/custom-enchant-table?style=flat-square)

Paper-плагин с отдельным GUI для зачарований через кастомный стол.

[Release](https://github.com/crysscoder/custom-enchant-table/releases/latest) · [Issues](https://github.com/crysscoder/custom-enchant-table/issues) · [CodeAdapter](https://codeadapter.ru)

</div>

## Что делает

- выдаёт предмет кастомного стола через `/giveTable`
- открывает меню при клике по столу зачарований
- показывает доступные зачарования для предмета
- даёт выбрать уровень и списывает опыт
- поддерживает справочник зачарований из `config.json`

## Версии

| Компонент | Версия |
| --- | --- |
| Plugin | `1.0.0` |
| Java | `17` |
| Paper | `1.20.1` |
| Paper API | `1.20.1-R0.1-SNAPSHOT` |

## Команды

- `/giveTable`

## Сборка

```bash
./gradlew clean build
```

Для Windows:

```powershell
.\gradlew.bat clean build
```
