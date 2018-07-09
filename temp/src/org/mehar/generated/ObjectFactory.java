
package org.mehar.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.mehar.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FetchCategoriesResponse_QNAME = new QName("http://testmart.com", "fetchCategoriesResponse");
    private final static QName _GetProductsv2Response_QNAME = new QName("http://testmart.com", "getProductsv2Response");
    private final static QName _FetchCategories_QNAME = new QName("http://testmart.com", "fetchCategories");
    private final static QName _AddProduct_QNAME = new QName("http://testmart.com", "addProduct");
    private final static QName _AddProductResponse_QNAME = new QName("http://testmart.com", "addProductResponse");
    private final static QName _GetProductsResponse_QNAME = new QName("http://testmart.com", "getProductsResponse");
    private final static QName _GetProductsv2_QNAME = new QName("http://testmart.com", "getProductsv2");
    private final static QName _GetProducts_QNAME = new QName("http://testmart.com", "getProducts");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mehar.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductsv2Response }
     * 
     */
    public GetProductsv2Response createGetProductsv2Response() {
        return new GetProductsv2Response();
    }

    /**
     * Create an instance of {@link FetchCategoriesResponse }
     * 
     */
    public FetchCategoriesResponse createFetchCategoriesResponse() {
        return new FetchCategoriesResponse();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link FetchCategories }
     * 
     */
    public FetchCategories createFetchCategories() {
        return new FetchCategories();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link GetProductsv2 }
     * 
     */
    public GetProductsv2 createGetProductsv2() {
        return new GetProductsv2();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "fetchCategoriesResponse")
    public JAXBElement<FetchCategoriesResponse> createFetchCategoriesResponse(FetchCategoriesResponse value) {
        return new JAXBElement<FetchCategoriesResponse>(_FetchCategoriesResponse_QNAME, FetchCategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsv2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "getProductsv2Response")
    public JAXBElement<GetProductsv2Response> createGetProductsv2Response(GetProductsv2Response value) {
        return new JAXBElement<GetProductsv2Response>(_GetProductsv2Response_QNAME, GetProductsv2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "fetchCategories")
    public JAXBElement<FetchCategories> createFetchCategories(FetchCategories value) {
        return new JAXBElement<FetchCategories>(_FetchCategories_QNAME, FetchCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "getProductsResponse")
    public JAXBElement<GetProductsResponse> createGetProductsResponse(GetProductsResponse value) {
        return new JAXBElement<GetProductsResponse>(_GetProductsResponse_QNAME, GetProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsv2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "getProductsv2")
    public JAXBElement<GetProductsv2> createGetProductsv2(GetProductsv2 value) {
        return new JAXBElement<GetProductsv2>(_GetProductsv2_QNAME, GetProductsv2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testmart.com", name = "getProducts")
    public JAXBElement<GetProducts> createGetProducts(GetProducts value) {
        return new JAXBElement<GetProducts>(_GetProducts_QNAME, GetProducts.class, null, value);
    }

}
