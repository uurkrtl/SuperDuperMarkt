
# SuperDuperMarkt Product Management System

The SuperDuperMarkt Product Management System is an application designed to manage products, their prices, quality, and expiration dates. This console application provides functionalities to record products, update their quality and price daily, and enforce rules for discounting or removing products based on quality and expiration dates.

## Introduction

The SuperDuperMarkt Product Management System allows users to:

-   Enforce rules for discounting or removing products based on quality and expiration dates
-   Provide a daily overview of all products for the following days iteratively

## Installation

To run the SuperDuperMarkt Product Management System on your local machine, follow these steps:

1.  Clone this repository:

`git clone https://github.com/yourusername/superdupermarkt.git`

2.  Navigate to the project directory:

`cd superdupermarkt`

3.  Compile and run the application:

`javac SuperDuperMarkt.java
java SuperDuperMarkt`

## Usage

Upon running the application, you will be presented with the initial assortment of products and their starting values. Follow the on-screen instructions to interact with the system and perform actions such as viewing daily overviews of products.

## Processing Rules

The SuperDuperMarkt Product Management System follows these processing rules:

-   Every product has a fixed base price.
-   The day's price is determined by the product's quality.
-   Cheese requires a minimum quality level to be shelved and loses one quality point daily.
-   Wine does not lose quality and gains +1 quality every 10 days until it reaches a maximum quality level.
-   Cheese has an expiration date between 50 and 100 days in the future.
-   Wine does not expire.

## Contributing

Contributions to the SuperDuperMarkt Product Management System are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For any inquiries or feedback, please contact ergot_birkac009 [at] icloud. com.