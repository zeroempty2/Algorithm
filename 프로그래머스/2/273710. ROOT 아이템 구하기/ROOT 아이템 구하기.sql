SELECT 
    INF.ITEM_ID, INF.ITEM_NAME
FROM 
    ITEM_INFO INF
JOIN 
    ITEM_TREE TR ON INF.ITEM_ID = TR.ITEM_ID
WHERE 
    TR.PARENT_ITEM_ID IS NULL
ORDER BY 
    INF.ITEM_ID