# Clearpoint software dev technical questionnaire and task

The repository for the clearpoint Java questionnaire

## Data Model
![ERD Diagram](ERD.png)

## Database Query
> SELECT
    d.DriverEmail as DRIVER_EMAIL,
    dt.DeliveryType as DELIVERY_TYPE,
    SUM(pd.Quantity) as QUANTITY_OF_ALL_PRODUCTS
  FROM Driver d
  JOIN DriverDelivery dd 
    ON d.DriverID = dd.DriverID
  JOIN DeliveryType dt
    ON dd.DeliveryTypeID = dt.DeliveryTypeID
  JOIN ProductDelivery pd
    ON dd.DriverDeliveryID = pd.DriverDeliveryID
  JOIN Product p
    ON pd.ProductID = p.ProductID
  WHERE dd.DeliveryDate = '2021-09-21'
  GROUP BY d.DriverEmail, dt.DeliveryType
  ORDER BY d.DriverEmail, dt.DeliveryType;

![SQL Query](QueryScreenshot.png)