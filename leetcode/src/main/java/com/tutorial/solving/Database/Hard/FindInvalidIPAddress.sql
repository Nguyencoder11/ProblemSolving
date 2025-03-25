WITH Invalid_IPs AS (
    SELECT
        ip,
        COUNT(*) AS invalid_count
    FROM logs
    WHERE 
        -- Kiểm tra số lượng octet khác 4
        LENGTH(ip) - LENGTH(REPLACE(ip, '.', '')) + 1 <> 4
        
        -- Kiểm tra giá trị của từng octet > 255 hoặc có leading zero
        OR SUBSTRING_INDEX(ip, '.', 1) NOT REGEXP '^(0|[1-9][0-9]{0,2})$'
        OR CAST(SUBSTRING_INDEX(ip, '.', 1) AS UNSIGNED) > 255
        
        OR SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 2), '.', -1) NOT REGEXP '^(0|[1-9][0-9]{0,2})$'
        OR CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 2), '.', -1) AS UNSIGNED) > 255
        
        OR SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 3), '.', -1) NOT REGEXP '^(0|[1-9][0-9]{0,2})$'
        OR CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 3), '.', -1) AS UNSIGNED) > 255
        
        OR SUBSTRING_INDEX(ip, '.', -1) NOT REGEXP '^(0|[1-9][0-9]{0,2})$'
        OR CAST(SUBSTRING_INDEX(ip, '.', -1) AS UNSIGNED) > 255
    GROUP BY ip
)

SELECT ip, invalid_count
FROM Invalid_IPs
ORDER BY invalid_count DESC, ip DESC;
