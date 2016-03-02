package qiang.finance.intradaydata.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Qiang He on 01/03/2016.
 */
@Entity
@Table(name = "DATA_SOURCE_DEFINITION")
public class DataSourceDefinition implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @Column(name = "HTTP_METHOD")
    private String httpMethod;

    @Column(name = "REQUEST_STRING")
    private String requestString;

    @Column(name = "RESPONSE_TYPE")
    private String responseType;

    @Column(name = "RESPONSE_STRING")
    private String responseString;
}
