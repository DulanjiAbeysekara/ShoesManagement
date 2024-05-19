$('#btnItemSave').click(function (){

    let itemCode=$('#txtItemCode').val();
    let  itemDesc=$('#txtItemDesc').val();
    let itemPicture=$('#txtItemPicture').val();
    let category=$('#txtCategory').val();
    let size=$('#txtSize').val();
    let supplierCode=$('#txtSupplierCode1').val();
    let supplierName=$('#txtSupplierName2').val();
    let unitPriceSale=$('#txtUnitPriceSale').val();
    let unitPriceBuy=$('#txtUnitPriceBuy').val();
    let expectedProfit=$('#txtExpectedProfit').val();
    let profitMargin=$('#txtProfitMargin').val();
    let status=$('#txtInventoryStatus').val();

    var item={
        itemCode:itemCode,
        itemDesc:itemDesc,
        itemPicture:itemPicture,
        category:category,
        size:size,
        supplierCode:supplierCode,
        supplierName:supplierName,
        unitPriceSale:unitPriceSale,
        unitPriceBuy:unitPriceBuy,
        expectedProfit:expectedProfit,
        profitMargin:profitMargin,
        status:status
    }

    $.ajax({
        url: 'http://localhost:8080/app1/inventory/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(item),
        success: function (response) {
            alert('Item information saved successfully!');
            console.log(item);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error saving item information:', error);
            alert('Item Not Found!');
        }
    });
});

$('#btnItemUpdate').click(function (){

    let itemCode=$('#txtItemCode').val();
    let  itemDesc=$('#txtItemDesc').val();
    let itemPicture=$('#txtItemPicture').val();
    let category=$('#txtCategory').val();
    let size=$('#txtSize').val();
    let supplierCode=$('#txtSupplierCode1').val();
    let supplierName=$('#txtSupplierName2').val();
    let unitPriceSale=$('#txtUnitPriceSale').val();
    let unitPriceBuy=$('#txtUnitPriceBuy').val();
    let expectedProfit=$('#txtExpectedProfit').val();
    let profitMargin=$('#txtProfitMargin').val();
    let status=$('#txtInventoryStatus').val();

    var item={
        itemCode:itemCode,
        itemDesc:itemDesc,
        itemPicture:itemPicture,
        category:category,
        size:size,
        supplierCode:supplierCode,
        supplierName:supplierName,
        unitPriceSale:unitPriceSale,
        unitPriceBuy:unitPriceBuy,
        expectedProfit:expectedProfit,
        profitMargin:profitMargin,
        status:status

    }

    $.ajax({
        url: 'http://localhost:8080/app1/inventory/update',
        type: 'PATCH',
        contentType: 'application/json',
        data: JSON.stringify(item),
        success: function (response) {
            alert('Item information updated successfully!');
            console.log(item);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error updating item information:', error);
            alert('Item Not Found!');
        }
    });

});


$("#btnItemDlt").click(function (){
    let itemCode=$('#txtItemCode').val();

    $.ajax({
        url: 'http://localhost:8080/app1/inventory/' + itemCode,
        type: 'DELETE',
        success: function (response) {
            alert('Item information deleted successfully!');
            console.log('Deleted item with code:', itemCode);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error deleting item information:', error);
            alert('Item Not Found!');
        }
    });

});