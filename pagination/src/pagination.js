import React, { useState, useEffect } from 'react';
 
 
const Pagination = () => {
    const [data, setData] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [itemsPerPage] = useState(10);
    const [totalPages, setTotalPages] = useState(1);  
   
   
    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(`https://jsonplaceholder.typicode.com/comments`);
            const result = await response.json();
            setData(result);
            setTotalPages(Math.ceil(result.length / itemsPerPage));
            console.log("hello");
        };
        fetchData();
    });
 
   
    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;
    const currentItems = data.slice(indexOfFirstItem, indexOfLastItem);
 
   
    const handleNextPage = () => {
        if (currentPage < totalPages) {
            setCurrentPage(prevPage => prevPage + 1);
        }
    };
 
    const handlePrevPage = () => {
        if (currentPage > 1) {
            setCurrentPage(prevPage => prevPage - 1);
        }
    };
 
    return (
       
        <div className="pagination-container">
            <h2 style={{ color: 'blue' }}>Paginated Data</h2>
            <ul className="data-list">
                {currentItems.map(item => (
                    <li> {item.email}  </li>
                ))}
            </ul>
            <div className="pagination-buttons">
                <button onClick={handlePrevPage} disabled={currentPage === 1} style={{backgroundColor:'lightGreen'}}>
                    Previous
                </button>
                <span style={{ color: 'red' }}>{`Page ${currentPage} of ${totalPages}`}</span>
                <button onClick={handleNextPage} disabled={currentPage === totalPages} style={{backgroundColor:'lightGreen'}}>
                    Next
                </button>
            </div>
        </div>
    );
};
 
export default Pagination;
