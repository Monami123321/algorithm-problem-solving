select count(*) as COUNT from ECOLI_DATA  
where (GENOTYPE & 1 << 1) = 0 AND (GENOTYPE & 5 <> 0)