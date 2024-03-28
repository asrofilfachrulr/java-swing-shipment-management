SELECT 
    dr.*, 
    c.name AS origin_name, 
    c.metric AS origin_metric, 
    c.name_abbr AS origin_name_abbr, 
    c2.name AS dest_name, 
    c2.metric AS dest_metric, 
    c2.name_abbr AS dest_name_abbr 
FROM 
    delivery_requests dr 
JOIN 
    cities c ON dr.city_origin_id = c.id 
JOIN 
    cities c2 ON dr.city_dest_id = c2.id 
JOIN 
    package_deliveries pd ON dr.id = pd.delivery_req_id 
WHERE 
    pd.id = 2;
