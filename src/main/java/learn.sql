select max(count1),supplierId from (SELECT count(*) as count1,supplierId from  Products group by supplierId)
select count1,supplierId from (SELECT count(*) as count1,supplierId from  Products group by supplierId) where supplierId=2
SELECT * FROM Orders WHERE OrderDate between '1996-07-04' and '1996-07-08';
SELECT TOP 3 * FROM Customers order by CustomerId desc;
SELECT * FROM Customers order by CustomerId desc  LIMIT 3;
SELECT * FROM Customers 
SELECT CustomerId FROM Customers union select CustomerId from Customers WHERE Country='Germany' AND ROWNUM <= 3;
SELECT CustomerId FROM Customers union select CustomerId from Customers
SELECT  distinct Count(*) FROM OrderDetails group by productId;
SELECT
CASE
    WHEN Quantity % 2=0 THEN 0
    ELSE 1
END
as test
FROM OrderDetails;