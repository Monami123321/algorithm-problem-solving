-- 코드를 입력하세요
SELECT hour(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
where hour(DATETIME)>=9 AND hour(DATETIME) <=19
group by hour(DATETIME)
order by HOUR ASC
