package bms.utils;

public class StatusCode {

	// 1xx Informational
	/**
	 * 100 Continue: 初始部分已接收，客户端可继续请求。
	 */
	public static final int CONTINUE = 100;

	/**
	 * 101 Switching Protocols: 服务器正在根据客户端请求更改协议。
	 */
	public static final int SWITCHING_PROTOCOLS = 101;

	/**
	 * 102 Processing: WebDAV 处理，服务器已接收到请求并正在处理。
	 */
	public static final int PROCESSING = 102;

	// 2xx Success
	/**
	 * 200 OK: 请求成功，服务器返回所请求的数据。
	 */
	public static final int OK = 200;

	/**
	 * 201 Created: 请求成功，服务器创建了一个新的资源。
	 */
	public static final int CREATED = 201;

	/**
	 * 202 Accepted: 请求已接收，但尚未处理。
	 */
	public static final int ACCEPTED = 202;

	/**
	 * 203 Non-Authoritative Information: 返回的信息来自第三方服务器。
	 */
	public static final int NON_AUTHORITATIVE_INFORMATION = 203;

	/**
	 * 204 No Content: 请求成功，但没有返回内容。
	 */
	public static final int NO_CONTENT = 204;

	/**
	 * 205 Reset Content: 请求成功，重置文档视图。
	 */
	public static final int RESET_CONTENT = 205;

	/**
	 * 206 Partial Content: 服务器成功处理了部分请求。
	 */
	public static final int PARTIAL_CONTENT = 206;

	/**
	 * 207 Multi-Status: WebDAV 请求多个状态码的响应。
	 */
	public static final int MULTI_STATUS = 207;

	/**
	 * 208 Already Reported: WebDAV 内部元素已被枚举。
	 */
	public static final int ALREADY_REPORTED = 208;

	/**
	 * 226 IM Used: 服务器满足了请求，响应一个或多个实例。
	 */
	public static final int IM_USED = 226;

	// 3xx Redirection
	/**
	 * 300 Multiple Choices: 客户端请求的资源有多个可能的响应。
	 */
	public static final int MULTIPLE_CHOICES = 300;

	/**
	 * 301 Moved Permanently: 资源的 URL 已永久改变。
	 */
	public static final int MOVED_PERMANENTLY = 301;

	/**
	 * 302 Found: 请求的资源临时存在于另一个 URL。
	 */
	public static final int FOUND = 302;

	/**
	 * 303 See Other: 客户端应通过另一个 URI 获取资源。
	 */
	public static final int SEE_OTHER = 303;

	/**
	 * 304 Not Modified: 资源未修改，客户端可以使用缓存的版本。
	 */
	public static final int NOT_MODIFIED = 304;

	/**
	 * 305 Use Proxy: 客户端必须通过代理访问资源。
	 */
	public static final int USE_PROXY = 305;

	/**
	 * 307 Temporary Redirect: 临时重定向，资源暂时移动。
	 */
	public static final int TEMPORARY_REDIRECT = 307;

	/**
	 * 308 Permanent Redirect: 资源已永久移动至新 URL。
	 */
	public static final int PERMANENT_REDIRECT = 308;

	// 4xx Client Error
	/**
	 * 400 Bad Request: 请求无效，服务器无法理解请求。
	 */
	public static final int BAD_REQUEST = 400;

	/**
	 * 401 Unauthorized: 请求未授权，需验证身份。
	 */
	public static final int UNAUTHORIZED = 401;

	/**
	 * 402 Payment Required: 预留状态码，目前未使用。
	 */
	public static final int PAYMENT_REQUIRED = 402;

	/**
	 * 403 Forbidden: 请求被服务器拒绝，禁止访问。
	 */
	public static final int FORBIDDEN = 403;

	/**
	 * 404 Not Found: 请求的资源无法找到。
	 */
	public static final int NOT_FOUND = 404;

	/**
	 * 405 Method Not Allowed: 请求的方法不被允许。
	 */
	public static final int METHOD_NOT_ALLOWED = 405;

	/**
	 * 406 Not Acceptable: 请求的内容特性无法满足请求头要求。
	 */
	public static final int NOT_ACCEPTABLE = 406;

	/**
	 * 407 Proxy Authentication Required: 需要代理身份验证。
	 */
	public static final int PROXY_AUTHENTICATION_REQUIRED = 407;

	/**
	 * 408 Request Timeout: 客户端请求超时。
	 */
	public static final int REQUEST_TIMEOUT = 408;

	/**
	 * 409 Conflict: 请求的资源与当前状态存在冲突。
	 */
	public static final int CONFLICT = 409;

	/**
	 * 410 Gone: 资源已永久删除，不会再被提供。
	 */
	public static final int GONE = 410;

	/**
	 * 411 Length Required: 需要指定请求的内容长度。
	 */
	public static final int LENGTH_REQUIRED = 411;

	/**
	 * 412 Precondition Failed: 服务器未能满足请求的前提条件。
	 */
	public static final int PRECONDITION_FAILED = 412;

	/**
	 * 413 Payload Too Large: 请求体过大，服务器无法处理。
	 */
	public static final int PAYLOAD_TOO_LARGE = 413;

	/**
	 * 414 URI Too Long: 请求的 URI 过长，服务器无法处理。
	 */
	public static final int URI_TOO_LONG = 414;

	/**
	 * 415 Unsupported Media Type: 请求的媒体格式不受支持。
	 */
	public static final int UNSUPPORTED_MEDIA_TYPE = 415;

	/**
	 * 416 Range Not Satisfiable: 请求的范围无效。
	 */
	public static final int RANGE_NOT_SATISFIABLE = 416;

	/**
	 * 417 Expectation Failed: 服务器无法满足请求头中的期望值。
	 */
	public static final int EXPECTATION_FAILED = 417;

	/**
	 * 418 I'm a teapot: 一个愚人节彩蛋状态码（RFC 2324），表示服务器是茶壶无法煮咖啡。
	 */
	public static final int I_AM_A_TEAPOT = 418;

	/**
	 * 421 Misdirected Request: 服务器错误地处理了该请求。
	 */
	public static final int MISDIRECTED_REQUEST = 421;

	/**
	 * 422 Unprocessable Entity: 请求格式正确但语义错误。
	 */
	public static final int UNPROCESSABLE_ENTITY = 422;

	/**
	 * 423 Locked: 资源被锁定（WebDAV）。
	 */
	public static final int LOCKED = 423;

	/**
	 * 424 Failed Dependency: 由于前一个请求失败，当前请求也失败（WebDAV）。
	 */
	public static final int FAILED_DEPENDENCY = 424;

	/**
	 * 425 Too Early: 服务器不愿意处理尚未准备好的请求。
	 */
	public static final int TOO_EARLY = 425;

	/**
	 * 426 Upgrade Required: 客户端应升级到不同的协议。
	 */
	public static final int UPGRADE_REQUIRED = 426;

	/**
	 * 428 Precondition Required: 请求需要满足一定的前提条件。
	 */
	public static final int PRECONDITION_REQUIRED = 428;

	/**
	 * 429 Too Many Requests: 客户端发送了太多的请求。
	 */
	public static final int TOO_MANY_REQUESTS = 429;

	/**
	 * 431 Request Header Fields Too Large: 请求头字段太大。
	 */
	public static final int REQUEST_HEADER_FIELDS_TOO_LARGE = 431;

	// 5xx Server Error
	/**
	 * 500 Internal Server Error: 服务器内部错误，无法完成请求。
	 */
	public static final int INTERNAL_SERVER_ERROR = 500;

	/**
	 * 501 Not Implemented: 服务器不支持所请求的功能。
	 */
	public static final int NOT_IMPLEMENTED = 501;

	/**
	 * 502 Bad Gateway: 网关或代理收到无效响应。
	 */
	public static final int BAD_GATEWAY = 502;

	/**
	 * 503 Service Unavailable: 服务器当前无法处理请求，通常是由于过载或维护。
	 */
	public static final int SERVICE_UNAVAILABLE = 503;

	/**
	 * 504 Gateway Timeout: 网关或代理未及时从上游服务器获取响应。
	 */
	public static final int GATEWAY_TIMEOUT = 504;

	/**
	 * 505 HTTP Version Not Supported: 服务器不支持请求的 HTTP 版本。
	 */
	public static final int HTTP_VERSION_NOT_SUPPORTED = 505;

	/**
	 * 506 Variant Also Negotiates: 服务器内部配置错误，导致内容协商失败。
	 */
	public static final int VARIANT_ALSO_NEGOTIATES = 506;

	/**
	 * 507 Insufficient Storage: 服务器存储空间不足，无法完成请求（WebDAV）。
	 */
	public static final int INSUFFICIENT_STORAGE = 507;

	/**
	 * 508 Loop Detected: 服务器检测到无限循环请求（WebDAV）。
	 */
	public static final int LOOP_DETECTED = 508;

	/**
	 * 510 Not Extended: 请求需进一步扩展。
	 */
	public static final int NOT_EXTENDED = 510;

	/**
	 * 511 Network Authentication Required: 需要网络认证。
	 */
	public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;

}
//mvn spring-javaformat:apply
