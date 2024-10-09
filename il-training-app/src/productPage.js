// src/ProductPage.js

import React, { useEffect, useState } from 'react';
import Product from './product';
import productslist from './productsList';

const ProductPage = ({ addToCart, cart }) => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchProducts = () => {
            setProducts(productslist);
        };

        fetchProducts();
    }, []);

    return (
        <div>
            <h1>Product List</h1>
            <div className="container">
                {products.map(product => (
                    <Product 
                        key={product.id} 
                        product={product} 
                        addToCart={addToCart} 
                        cart={cart} 
                    />
                ))}
            </div>
        </div>
    );
};

export default ProductPage;


