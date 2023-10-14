-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(PRICE*SALES_AMOUNT) as SALES
from product p
inner join OFFLINE_SALE o
on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by SALES DESC, p.PRODUCT_CODE ASC