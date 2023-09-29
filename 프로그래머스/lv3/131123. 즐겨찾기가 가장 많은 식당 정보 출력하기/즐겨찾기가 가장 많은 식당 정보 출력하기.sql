SELECT R.FOOD_TYPE,R.REST_ID,R.REST_NAME,R.FAVORITES
FROM REST_INFO R
JOIN 
(SELECT FOOD_TYPE, max(FAVORITES) AS FAV
 FROM REST_INFO
 GROUP BY FOOD_TYPE) F
ON R.FOOD_TYPE = F.FOOD_TYPE
AND R.FAVORITES = F.FAV
ORDER BY FOOD_TYPE desc
      
