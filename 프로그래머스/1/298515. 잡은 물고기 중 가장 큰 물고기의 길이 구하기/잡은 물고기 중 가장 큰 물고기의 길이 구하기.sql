select concat(LENGTH, "cm") MAX_LENGTH
from FISH_INFO
order by LENGTH DESC
limit 1;