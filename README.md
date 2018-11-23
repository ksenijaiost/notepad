# notepad
Данное приложение было разработано в качестве практики при изучении языка.

---
Запуск
e:
cd E:\Java\practice\notepad
gradle jRun

Конект к серверу
e:
cd E:\Java\practice\notepad
java -cp E:/Java/practice/notepad/hsqldb//lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb

Включить менеджер
e:
cd E:\Java\practice\notepad
java -cp E:/Java/practice/notepad/hsqldb/lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
Соединение: NoteDB, Server, подписать: jdbc:hsqldb:hsql://localhost/xdb
