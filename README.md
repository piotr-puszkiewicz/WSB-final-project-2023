# WSB-projekt-końcowy-2023
Projekt końcowy WSB Programista Java 2022/2023


## Przykładowe zapytania

### Tworzenie projektów

```sql
INSERT INTO project ( id, code, description, enabled, name )
VALUES ( NEXTVAL('project_seq'), 'WSB', 'Projekt pokazowy', TRUE, 'WSB -- Projekt pokazowy' );
INSERT INTO project ( id, code, description, enabled, name )
VALUES ( NEXTVAL('project_seq'), 'JAVA', 'Projekt JAVA', TRUE, 'JAVA' );
INSERT INTO project ( id, code, description, enabled, name )
VALUES ( NEXTVAL('project_seq'), 'DB', 'Bazy danych', TRUE, 'Bazy danych' );
```

```java
-Dspring.datasource.url=jdbc:postgresql://localhost:5432/wsb-final-project-2023"
-Dspring.datasource.username=wsb_db

-Dspring.datasource.url="jdbc:postgresql://wsb-final-project-2023"
-Dspring.datasource.username=wsb_db
-Dspring.datasource.password=Nokia6680!