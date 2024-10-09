import React from 'react';

const Product = ({ product, addToCart, cart }) => {
    const isInCart = cart.some(item => item.id === product.id);
    const quantity = isInCart ? cart.find(item => item.id === product.id).quantity : 0;

    const handleAddClick = () => {
        addToCart(product, 1); // Add 1 to the cart
    };

    const handleRemoveClick = () => {
        if (quantity > 0) {
            // Decrease quantity, and if it reaches 0, remove the product
            addToCart(product, -1);
        }
    };

    return (
        <div className="product">
            <h2>{product.name}</h2>
            <p>ID: {product.id}</p>
            <p>Price: ${product.price}</p>
            <div className="button-group">
                {isInCart ? (
                    <>
                        <button onClick={handleRemoveClick} disabled={quantity <= 0}>
                            -
                        </button>
                        <span> Quantity: {quantity}</span>
                    </>
                ) : (
                    <button onClick={handleAddClick}>
                        Add to Cart
                    </button>
                )}
                {isInCart && (
                    <button onClick={handleAddClick}>
                        +
                    </button>
                )}
            </div>
        </div>
    );
};

export default Product;
