SELECT
    DISTINCT(ID),EMAIL,FIRST_NAME,LAST_NAME
FROM
    DEVELOPERS d
JOIN 
    SKILLCODES s ON s.NAME IN ('C#', 'Python')AND d.SKILL_CODE & s.CODE = s.CODE
ORDER BY
    1