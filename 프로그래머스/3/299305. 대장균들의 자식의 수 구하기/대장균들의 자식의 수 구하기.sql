SELECT 
    a.ID, count(b.PARENT_ID) as CHILD_COUNT
FROM 
    ECOLI_DATA a LEFT JOIN ECOLI_DATA b ON a.ID = b.PARENT_ID
GROUP BY
    1
ORDER BY
    1;