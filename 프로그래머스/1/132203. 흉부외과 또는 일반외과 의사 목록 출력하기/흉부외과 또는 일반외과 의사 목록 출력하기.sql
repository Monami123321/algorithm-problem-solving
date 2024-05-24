select DR_NAME, DR_ID, MCDP_CD,	date_format(HIRE_YMD,"%Y-%m-%d") HIRE_YMD
from DOCTOR
where MCDP_CD in ("GS", "CS")
order by HIRE_YMD DESC, DR_NAME;