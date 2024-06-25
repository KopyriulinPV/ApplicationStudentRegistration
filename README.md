Команды для запуска приложения через Docker.
Создание образа:
docker build -t application-student-registration .
Команда для создания и запуска нового контейнера Docker:
docker run -i application-student-registration
Команда для создания и запуска нового контейнера Docker c отключенным слушателем события старта приложения, 
который создаёт произвольное количество студентов в приложении при старте.
docker run -i -e CREATE_ON_STARTUP=false application-student-registration

После запуска контейнера Docker возможны следующие команды.
Показывает список сохраненных студентов: listStudents
Добавляет студента в список: addStudent 
Пример команды: addStudent --firstName Petr --lastName Kopyriulin --age 36
Удаление студента по id: deleteStudent 
Пример команды: deleteStudent --id 3
Удаление всех студентов из списка: deleteAllStudent.
