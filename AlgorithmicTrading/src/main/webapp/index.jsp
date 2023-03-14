<!DOCTYPE html>

<html>
  <body>
    <form action="MyServlet" method="GET">
     <label>Company_Id:</label>
        <input type="text" name="company_Id" /><br/><br/>
       <label>Select Side:</label>
        <input type="radio" name="side" value="Buy"  />Buy
        <input type="radio" name="side" value="Sale" />sale<br/><br/>
        <label>Quantity:</label>
        <input type="number" name="quantity" /><br/><br/>
        <label>Price:</label>
        <input type="number" name="price" /><br/><br/> 
      <input type="submit" value="submit">
    </form>
    
  
  </body>
</html>
