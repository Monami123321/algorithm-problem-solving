-- 코드를 입력하세요
SELECT ANIMAL_TYPE, if(NAME is null, "No name", Name) as Name, SEX_UPON_INTAKE
from ANIMAL_INS
order by ANIMAL_ID
