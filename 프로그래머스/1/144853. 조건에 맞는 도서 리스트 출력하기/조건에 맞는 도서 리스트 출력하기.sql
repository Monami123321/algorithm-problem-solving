select BOOK_ID, date_format(PUBLISHED_DATE,"%Y-%m-%d") PUBLISHED_DATE
from BOOK
where year(PUBLISHED_DATE) = 2021 && CATEGORY = "인문"
order by PUBLISHED_DATE