package interview.system.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2 // 启动swagger注解
public class SwaggerConfigurer {

	@Bean
	public Docket issueListAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Vanguard scrum team")
				.apiInfo(issueListAPIInfo())
				.select() // 选择那些路径和api会生成document
				//Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// .apis(RequestHandlerSelectors.any()) // 对所有API进行监控
//				.apis(RequestHandlerSelectors.basePackage("com.company.project.web"))// 此处改为你的接口所在的包路径

				.apis(RequestHandlerSelectors.basePackage("interview.endpoint"))// 此处改为你的接口所在的包路径
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any()) // 对所有路径进行监控
				.build();
	}

	private ApiInfo issueListAPIInfo() {
		Contact contact= new  Contact("Zhou Feng", "", "feng.zhou@tieto.com");
		return new ApiInfoBuilder()
				.title("Interview")
				.description("Interview resource provider")
				.contact(contact)
				.version("0.1")
				.build();// 此处改为你自己的项目名称，描述，作者，版本
	}

}