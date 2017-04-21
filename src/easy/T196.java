package easy;

/**
 * Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
 * @author Potato
 *
 */
public class T196 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//delete from Person where Id not in(select * from (select min(Id) from Person group by Email) t)
	}

}
