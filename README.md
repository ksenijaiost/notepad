# notepad
#### Данное приложение было разработано в качестве практики при изучении языка.

---
##### P.S. для запуска приложения на компьютере
###### Запуск
    e:
    cd E:\...\notepad
    gradle jRun

###### Конект к серверу
    e:
    cd E:\...\notepad
    java -cp E:/.../notepad/hsqldb//lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb

###### Включить менеджер
    e:
    cd E:\...\notepad
    java -cp E:/.../notepad/hsqldb/lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
    Соединение: NoteDB, Server, подписать: jdbc:hsqldb:hsql://localhost/xdb
