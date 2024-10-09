import React, { useState } from 'react';
import ProductPage from './productPage';
import Cart from './cart';
import './App.css';

const App = () => {
    const [cart, setCart] = useState([]);

    const addToCart = (product, quantity) => {
      setCart(prevCart => {
          const existingProduct = prevCart.find(item => item.id === product.id);
          if (existingProduct) {
              // If the product already exists, increase/decrease its quantity
              const newQuantity = existingProduct.quantity + quantity;
              if (newQuantity <= 0) {
                  // Remove item if quantity goes to 0 or less
                  return prevCart.filter(item => item.id !== product.id);
              }
              return prevCart.map(item =>
                  item.id === product.id
                      ? { ...item, quantity: newQuantity }
                      : item
              );
          } else {
              // If it's a new product, add it to the cart
              return [...prevCart, { ...product, quantity }];
          }
      });
  };
  

    const removeFromCart = (productId) => {
        setCart(prevCart => prevCart.filter(item => item.id !== productId));
    };

    const changeQuantity = (productId, amount) => {
        setCart(prevCart => {
            const product = prevCart.find(item => item.id === productId);
            if (product) {
                if (product.quantity + amount <= 0) {
                    return prevCart.filter(item => item.id !== productId); // Remove item if quantity goes to 0
                }
                return prevCart.map(item =>
                    item.id === productId
                        ? { ...item, quantity: item.quantity + amount }
                        : item
                );
            }
            return prevCart;
        });
    };

    return (
        <div className="container">
            <div className="product-page">
                <ProductPage addToCart={addToCart} cart={cart} />
            </div>
            <Cart cart={cart} removeFromCart={removeFromCart} changeQuantity={changeQuantity} />
        </div>
    );
};

export default App;
