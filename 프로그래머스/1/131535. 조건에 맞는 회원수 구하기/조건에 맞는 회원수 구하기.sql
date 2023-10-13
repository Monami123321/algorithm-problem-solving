-- 코드를 입력하세요
SELECT count(USER_ID) as USERS
from USER_INFO
where AGE >= 20 AND AGE <=29 AND year(JOINED) = 2021