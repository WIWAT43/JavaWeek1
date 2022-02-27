# JavaWeek1
การบ้าน JavaBootCamp Shopping


1.Search prodduct by name

ผู้ใช้งานสามารถส่งชื่อสินค้าเข้ามาค้นหาได้เลยโดยระบบจะทำการค้นหาคำในชื่อสินค้าให้

ตัวอย่างรูปแบบการค้นหา Product GET
http://localhost:8080/product/findByNameContaining/{Product Name}

รูปแบบตัวอย่างการคืนค่า เป็น Array

[
  {
    "productId": 1,
    "name": "Product01",
    "detail": "Product01 detail",
    "image": "https://xxx/product01.jpg",
    "price": 100
  }
]

2-3. Choose a product & Show product detail

เมื่อต้องการดูรายละเอียดสินค้าให้ทำการส่งค่า ID ของสินค้านั้นๆ เข้ามาในระบบ

ตัวอย่างรูปแบบการค้นหา Product 
GET
http://localhost:8080/product/findById/{Product ID}

รูปแบบตัวอย่างการคืนค่า

  {
    "productId": 1,
    "name": "Product01",
    "detail": "Product01 detail",
    "image": "https://xxx/product01.jpg",
    "price": 100
  }


4. Add product to basket

วิธี ADD สินค้าเข้าตระกร้า ให้ทำการส่ง User ID Product ID และจำนวนสินค้าที่ต้องการเข้าระบบ ระบบจะทำการบันทึกอัตโนมัต 
ตัวอย่างการ Add product to basket
POST
http://localhost:8080/basket/addProductToBasket

รูปแบบการส่งค่า

{
  "basketId": 0,
  "productId": 1,
  "productUnit": 3,
  "userId": 1
}

วิธีการใช้งาน ถ้าต้องการเพิ่มสินค้าเข้าตระก้าให้ใส่ ("basketId": 0) แต่ถ้าต้องการแก้ไข หรือเพิ่มจำนวนสินค้าสามารถ ใส่รหัส "basketId" ที่จะทำการแก้ไขให้เลย 
*ระบบจะบันทึกจำนวนสินค้าและข้อมูลตามที่ส่งเข้ามา 

รูปแบบตัวอย่างการคืนค่า
{
  "basketId": 1,
  "userId": 1,
  "userName": "user01",
  "productId": 1,
  "productName": "Product01",
  "detail": "Product01 detail",
  "image": "https://xxx/product01.jpg",
  "price": 100,
  "productUnit": 3
}

5-6. Show Data in basket

สามารถส่ง User ID เข้ามาค้นหาได้เลย

ตัวอย่างการ ค้นหาสินค้าใน basket ด้วย User ID
GET
http://localhost:8080/basket/findByUserId/{User ID}

ระบบจะแสดงเฉพาะรายการสินค้าในตระกร้าที่ยังไม่ได้ชำระเงิน

รูปแบบตัวอย่างการคืนค่า
[
  {
    "basketId": 1,
    "userId": 1,
    "userName": "user01",
    "productId": 1,
    "productName": "Product01",
    "detail": "Product01 detail",
    "image": "https://xxx/product01.jpg",
    "price": 100,
    "productUnit": 3
  },
  
]

7.Shipping

ตัวอย่างการ บันทึกที่อยู่สำหรับส่งสินค้า
Post
http://localhost:8080/userAddress/register

{
  "addressId": 0,
  "addressLine1": "string",
  "addressLine2": "string",
  "city": "string",
  "country": "string",
  "fullAddress": "string",
  "postalCode": "string",
  "statusActive": 0, // statusActive ตั้งค้าเป็นที่อยู่หลัก ให้ใส่ 1
  "userId": 0
}

8. Payment 

ตัวอย่างการ บันทึกวิธีชำระค่าใช้จ่าย
Post
http://localhost:8080/Payment/addUserPayment

{
  "cardName": "string",
  "cardNumber": "string",
  "ccv": "string",
  "monthExpire": 0,
  "paymentId": 0,
  "paymentType": 0,
  "statusActive": 0,   // statusActive ตั้งค้าเป็นที่อยู่หลัก ให้ใส่ 1
  "userId": 0,
  "yearExpire": 0
}

9-10. Confirm to oreder

Post
http://localhost:8080/Payment/paid

ให้ทำการส่งหมายเลขตระกล้าสินค้าพร้อมกับ User ID ระบบจะทำการ ดึงต่าอัตโนมัติ
{
  "basketId": [
    1,2
  ],
  "userId": 1
}

วิธีการตรวจสอบตระกร้าสินค้า
Get
http://localhost:8080/basket/findByUserId/{user ID}



เมื่อชำระสำเร็จจะคืนค่า Summary
{
  "transactionId": 1,
  "dateTime": "Sun Feb 27 19:37:40 ICT 2022",
  "totalPay": 1700,
  "userPaymentId": 1,
  "userFullName": "First Name 01 Last Name 01",
  "address": "Address Line1 Address Line2 Bangkok 10123 Thailand"
}