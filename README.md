# 🛒 Selenium Shopping Cart Automation Test

## 📋 Mô tả Project
Project tự động hóa test **React Shopping Cart** bằng **Selenium WebDriver + Java**.

**Demo website:** [React Shopping Cart](https://react-shopping-cart-67954.firebaseapp.com/)

## ✨ Tính năng đã test
✅ **Tìm kiếm & lấy thông tin elements** (text, href, src, img)  
✅ **Chọn size sản phẩm** (XS → XXL)  
✅ **Thêm sản phẩm vào giỏ hàng**  
✅ **Tăng số lượng sản phẩm** (+ button)  
✅ **Checkout giỏ hàng**  
✅ **Xử lý Alert popup**  
✅ **Xóa sản phẩm khỏi giỏ hàng**  

## 🛠️ Tech Stack
Java 11+ Selenium WebDriver 4.x ChromeDriver Maven (recommended) IntelliJ IDEA

## 🚀 Hướng dẫn chạy project

### 1. Clone project
```bash
git clone https://github.com/YOUR_USERNAME/selenium-school-project.git
cd selenium-school-project
2. Cài đặt dependencies (Maven)
mvn clean install
3. Download ChromeDriver
Tự động với WebDriverManager hoặc
Manual: ChromeDriver Downloads
4. Chạy test
# Chạy Main class
mvn exec:java -Dexec.mainClass="org.example.Main"

# Hoặc chạy trực tiếp trong IntelliJ IDEA
# Right-click Main.java → Run 'Main.main()'
```
📁 Cấu trúc Project

selenium-school-project/
├── .gitignore
├── pom.xml              # Maven dependencies
├── README.md           # 📄 File này!
└── src/
    └── main/
        └── java/
            └── org/
                └── example/
                    └── Main.java     # 💎 Code chính
🎬 Demo Flow Test
1. Mở https://react-shopping-cart-67954.firebaseapp.com/
2. Lấy thông tin: Star, Text, Image, Links
3. Chọn size XS → Add to Cart → Increase (+)
4. Close cart → Chọn size XXL
5. Add 2 sản phẩm khác vào cart
6. Checkout → Accept Alert
7. Delete all items → Close browser
📊 Console Output mẫu
Star
Work in the Netherlands...
https://example.com/image.jpg
https://linkedin.com/...
follow me on Linkedin.
+
X
Shopping Bag
👨‍💻 Author
Trần Minh Quân - GitHub Profile
📄 License
Project này dành cho mục đích học tập tại trường.
