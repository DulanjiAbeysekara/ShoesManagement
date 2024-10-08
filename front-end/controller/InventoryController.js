
$(document).ready(function () {
    generateInventoryID();
    getAll();

    $('#btnItemSave').click(function () {

        let itemCode = $('#txtItemCode').val();
        let itemDesc = $('#txtItemDesc').val();
        let itemPicture = $('#txtItemPicture').val();
        let category = $('#txtCategory').val();
        let size = $('#txtSize').val();
        let supplierCode = $('#txtSupplierCode1').val();
        let supplierName = $('#txtSupplierName2').val();
        let unitPriceSale = $('#txtUnitPriceSale').val();
        let unitPriceBuy = $('#txtUnitPriceBuy').val();
        let expectedProfit = $('#txtExpectedProfit').val();
        let profitMargin = $('#txtProfitMargin').val();
        let status = $('#txtInventoryStatus').val();

        var item = {
            itemCode: itemCode,
            itemDesc: itemDesc,
            itemPicture: itemPicture,
            category: category,
            size6: 4,
            size8:6,
            size10:8,
            size11:6,
            supplierCode: supplierCode,
            supplierName: supplierName,
            unitPriceSale: unitPriceSale,
            unitPriceBuy: unitPriceBuy,
            expectedProfit: expectedProfit,
            profitMargin: profitMargin,
            status: status
        }

        $.ajax({
            url: 'http://localhost:8080/inventory/save',
            type: 'POST',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
            contentType: 'application/json',
            data: JSON.stringify(item),
            success: function (response) {
                alert('Item information saved successfully!');
                console.log(item);
                clearFields()
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error saving item information:', error);
                alert('Item Not Found!');
            }
        });
    });

    $('#btnItemUpdate').click(function () {

        let itemCode = $('#txtItemCode').val();
        let itemDesc = $('#txtItemDesc').val();
        let itemPicture = $('#txtItemPicture').val();
        let category = $('#txtCategory').val();
        let size = $('#txtSize').val();
        let supplierCode = $('#txtSupplierCode1').val();
        let supplierName = $('#txtSupplierName2').val();
        let unitPriceSale = $('#txtUnitPriceSale').val();
        let unitPriceBuy = $('#txtUnitPriceBuy').val();
        let expectedProfit = $('#txtExpectedProfit').val();
        let profitMargin = $('#txtProfitMargin').val();
        let status = $('#txtInventoryStatus').val();

        var item = {
            itemCode: itemCode,
            itemDesc: itemDesc,
            itemPicture: itemPicture,
            category: category,
            size: size,
            supplierCode: supplierCode,
            supplierName: supplierName,
            unitPriceSale: unitPriceSale,
            unitPriceBuy: unitPriceBuy,
            expectedProfit: expectedProfit,
            profitMargin: profitMargin,
            status: status

        }

        $.ajax({
            url: 'http://localhost:8080/inventory/update',
            type: 'PATCH',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
            contentType: 'application/json',
            data: JSON.stringify(item),
            success: function (response) {
                alert('Item information updated successfully!');
                console.log(item);
                clearFields()
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error updating item information:', error);
                alert('Item Not Found!');
            }
        });

    });

    $("#btnItemDlt").click(function () {
        let itemCode = $('#txtItemCode').val();

        $.ajax({
            url: 'http://localhost:8080/inventory/' + itemCode,
            type: 'DELETE',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
            success: function (response) {
                alert('Item information deleted successfully!');
                console.log('Deleted item with code:', itemCode);
                clearFields()
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting item information:', error);
                alert('Item Not Found!');
            }
        });

    });

    $('#btnItemSearch').click(function (){

        let itemId = $('#txtItemSearch').val();
        searchInventoryById(itemId);

    });

    //////////////////////////////////methods////////////////////////////////////

    function searchInventoryById(id){
        $('#tblItem tbody').empty();

        $.ajax({
            url: 'http://localhost:8080/inventory/search/' + id,
            method: 'GET',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
            success: function (resp) {
                if (resp.length === 0) {
                    alert('No item found with the given id');
                    return;
                }
                for (const item of resp) {
                    let row = `<tr>
                                 <td>${item.itemCode}</td>
                                <td>${item.itemDesc}</td>
                                <td>${item.itemPicture}</td>
                                <td>${item.category}</td>
                                <td>${item.size}</td>
                                 <td>${item.supplierCode}</td>
                                <td>${item.supplierName}</td>
                                <td>${item.unitPriceSale}</td>
                                <td>${item.unitPriceBuy}</td>
                                <td>${item.expectedProfit}</td>
                                <td>${item.profitMargin}</td>
                               <td>${item.status}</td>
                                </tr>`;
                    $('#tblItem tbody').append(row);
                }
                bindClickEvents();
            },
            error: function (error) {
                console.log('Error:', error);
                alert('Error searching for customer!');
            }
        });
    }

    function getAll() {
        $('#tblItem tbody').empty();

        $.ajax({
            url: "http://localhost:8080/inventory/getAllInventory",
            method: "GET",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
            success: function (resp) {
                for (const item of resp) {
                    let row = `<tr>
                                <td>${item.itemCode}</td>
                                <td>${item.itemDesc}</td>
                                <td>${item.itemPicture}</td>
                                <td>${item.category}</td>
                                <td>${item.size}</td>
                                 <td>${item.supplierCode}</td>
                                <td>${item.supplierName}</td>
                                <td>${item.unitPriceSale}</td>
                                <td>${item.unitPriceBuy}</td>
                                <td>${item.expectedProfit}</td>
                                <td>${item.profitMargin}</td>
                               <td>${item.status}</td>
                            </tr>`;
                    $('#tblItem tbody').append(row);
                }
                bindClickEvents();
            },
            error: function (error) {
                console.log("Error: ", error);
            }
        });
    }

    function bindClickEvents() {
        $('#tblItem tbody>tr').click(function () {
            let itemCode = $(this).children(':nth-child(1)').text();
            let itemDesc = $(this).children(':nth-child(2)').text();
            let itemPicture = $(this).children(':nth-child(3)').text();
            let category = $(this).children(':nth-child(4)').text();
            let size = $(this).children(':nth-child(5)').text();
            let supplierCode = $(this).children(':nth-child(6)').text();
            let supplierName = $(this).children(':nth-child(7)').text();
            let unitPriceSale = $(this).children(':nth-child(8)').text();
            let unitPriceBuy = $(this).children(':nth-child(9)').text();
            let expectedProfit = $(this).children(':nth-child(10)').text();
            let profitMargin = $(this).children(':nth-child(11)').text();
            let status = $(this).children(':nth-child(12)').text();

            $('#txtItemCode').val(itemCode);
            $('#txtItemDesc').val(itemDesc);
            $('#txtItemPicture').val(itemPicture);
            $('#txtCategory').val(category);
            $('#txtSize').val(size);
            $('#txtSupplierCode1').val(supplierCode);
            $('#txtSupplierName2').val(supplierName);
            $('#txtUnitPriceSale').val(unitPriceSale);
            $('#txtUnitPriceBuy').val(unitPriceBuy);
            $('#txtExpectedProfit').val(expectedProfit);
            $('#txtProfitMargin').val(profitMargin);
            $('#txtInventoryStatus').val(status);
        });
    }

    function clearFields() {

         $('#txtItemCode').val("");
         $('#txtItemDesc').val("");
         $('#txtItemPicture').val("");
         $('#txtCategory').val("");
         $('#txtSize').val("");
         $('#txtSupplierCode1').val("");
         $('#txtSupplierName2').val("");
         $('#txtUnitPriceSale').val("");
         $('#txtUnitPriceBuy').val("");
         $('#txtExpectedProfit').val("");
         $('#txtProfitMargin').val("");
         $('#txtInventoryStatus').val("");

        $("#txtItemCode").focus();
    }

    function generateInventoryID() {
        $("#txtItemCode").val("ITEM00-001");
        $.ajax({
            url: "http://localhost:8080/inventory/itemIdGenerate",
            method: "GET",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
            contentType: "application/json",
            dataType: "json",
            success: function (resp) {
                let id = resp.value;
                if (id) {
                    let tempId = parseInt(id.split("-")[1]) + 1;
                    let newId = "ITEM00-" + tempId.toString().padStart(3, '0');
                    $("#txtItemCode").val(newId);
                }
            },
            error: function (ob, statusText, error) {
                console.error("Error generating customer ID:", statusText, error);
            }
        });
    }


});