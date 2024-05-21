select HISTORY_ID, CAR_ID, date_format(START_DATE, "%Y-%m-%d") START_DATE, date_format(END_DATE, "%Y-%m-%d") END_DATE,
if(datediff(END_DATE, START_DATE) + 1 >= 30, "장기 대여", "단기 대여") RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where "2022-09-01" <= START_DATE and START_DATE < "2022-10-01"
order by HISTORY_ID DESC;
