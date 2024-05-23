select i.FLAVOR
from FIRST_HALF f
inner join ICECREAM_INFO i
using (FLAVOR)
where f.TOTAL_ORDER > 3000 and i.INGREDIENT_TYPE = "fruit_based"
order by f.TOTAL_ORDER DESC;