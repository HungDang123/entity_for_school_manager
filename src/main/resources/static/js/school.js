// // table of school
// const stocks = [
//     {
//         src: 'assets/shell.png',
//         name: 'Shell plc',
//         ticker: 'SHEL',
//         price: 64.53,
//         change: 0.45,
//         marketCap: '215.6B',
//         peRatio: 7.88,
//         dividendYield: 4.08,
//         volume: '5.2M',
//     },
//     {
//         src: 'assets/apple.png',
//         name: 'Apple Inc',
//         ticker: 'AAPL',
//         price: 194.39,
//         change: 0.12,
//         marketCap: '2.732T',
//         peRatio: 29.32,
//         dividendYield: '0.54',
//         volume: '42M',
//     },
//     {
//         src: 'assets/tesla.png',
//         name: 'Tesla Inc',
//         ticker: 'TSLA',
//         price: 254.33,
//         change: -5.08,
//         marketCap: '816B',
//         peRatio: 73.01,
//         dividendYield: 'N/A',
//         volume: '8.4M',
//     },
//     {
//         src: 'assets/nvidia.png',
//         name: 'NVidia Corporation',
//         ticker: 'NVDA',
//         price: 495.22,
//         change: -2.20,
//         marketCap: '1.223T',
//         peRatio: 65.33,
//         dividendYield: '0.03',
//         volume: '38M',
//     },
//
// ]
//
//
// let tableRowCount = document.getElementsByClassName('table-row-count');
// tableRowCount[0].innerHTML = `(${stocks.length}) Stocks`;
//
// let tableBody = document.getElementById('table-rows');
//
// const mappedRecords = stocks
//     .map(
//         (stock) => {
//             return `<tr>
//     <td class="stock sticky-left">
//         <div class="stock-wrapper">
//             <img src="${stock.src}" alt="${stock.name}">
//             <div class="stock-info">
//                 <span class="stock-info__ticker">
//                     ${stock.ticker}
//                 </span>
//                 <span class="stock-info__name">
//                     ${stock.name}
//                 </span>
//             </div>
//         </div>
//     </td>
//     <td>${stock.price}</td>
//     <td class="price ${stock.change >= 0 ? 'up' : 'down'}">${stock.change}</td>
//     <td class="price ${stock.change >= 0 ? 'up' : 'down'}">
//         ${parseFloat(stock.change / stock.price * 100).toFixed(2)}
//     </td>
//      <td class="price ${stock.change >= 0 ? 'up' : 'down'}">
//         ${parseFloat(stock.change / stock.price * 100).toFixed(2)}
//     </td>
//     <td>
//         ${stock.marketCap}
//     </td>
//     <td class="sticky-right">
//         <button class="btn btn--primary">Edit</button>
//     </td>
//     <td class="sticky-right">
//         <button class="btn btn--danger">Delete</button>
//     </td>
//     <td class="sticky-right">
//         <button class="btn btn--info">View</button>
//     </td>
// </tr>`;
//         });
//
// const tableWrapper = document.querySelector('.table-wrapper');
//
// tableWrapper.innerHTML = DOMPurify.sanitize(`
//     <table>
//         <thead>
//             <tr>
//                 <th class="sticky-left">School name</th>
//                 <th>Address</th>
//                 <th>Phone number</th>
//                 <th>The number of student</th>
//                 <th>Type of school</th>
//                 <th>Revenue</th>
//                 <th class="sticky-right"></th>
//                 <th class="sticky-right"></th>
//                 <th class="sticky-right"></th>
//             </tr>
//         </thead>
//         <tbody id="table-rows">
//             ${mappedRecords.join('')}
//         </tbody>
//         <!-- <tfoot>
//                 My footer
//         </tfoot> -->
//     </table>
// `);
