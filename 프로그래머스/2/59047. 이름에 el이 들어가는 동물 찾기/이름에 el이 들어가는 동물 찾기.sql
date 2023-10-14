-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where upper(NAME) like '%EL%' AND ANIMAL_TYPE = "Dog"
order by upper(NAME) ASC