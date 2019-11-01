- [gRPCテストコード](#grpc%e3%83%86%e3%82%b9%e3%83%88%e3%82%b3%e3%83%bc%e3%83%89)
- [gRPCについて](#grpc%e3%81%ab%e3%81%a4%e3%81%84%e3%81%a6)
- [事例](#%e4%ba%8b%e4%be%8b)
- [通信仕様](#%e9%80%9a%e4%bf%a1%e4%bb%95%e6%a7%98)

# gRPCテストコード

|ディレクトリ|内容|
|:--|:--|
|grpc-be|Unary gRPCサーバ|
|grpc-fe|Unary gRPCサーバのクライアント|
|grpc-stream-be|ServerStreaming gRPCサーバ|
|grpc-stream-fe|ServerStreaming gRPCサーバのクライアント|
|http-be|比較用HTTPサーバ|
|http-fe|比較用HTTPサーバのクライアント|

# gRPCについて

![image](https://user-images.githubusercontent.com/1765590/68037343-debded00-fd0a-11e9-9792-0924d9fe17d3.png)

- Googleが開発したRPCフレームワーク。(2015年に発表され、2016/8にVersion1.0がリリースされた)
- 同社が開発したProtocol BufferというIDLからクライアント・サーバサイドの通信レイヤーのソースコードを自動生成できる
- 通信プロトコルはHTTP/2
- 高いパフォーマンスの持つアプリケーションを低コストで開発できる
- Protocol Bufferでデータスキーマも異なるアプリケーション・言語をまたいで同一のコードを使う為、巨大なマイクロサービスシステムとも相性が良い
- 対応言語的にiOSやAndroidなどのクライアントサイドでも使える。ただ、その場合クライアントが対応している通信プロトコルとgRPC(HTTP/2)の互換性を持たせる為のプロキシ(grpc-gateway)が必要になる。
- https://github.com/grpc/grpc-web ではブラウザ上のJSでそのまま扱う事ができる(HTTP/2に対応しているブラウザが必要)

# 事例

- Googleは社内のアプリケーション間通信はほぼgRPCと言われている。それ以外でもSquare,Netflix,Ciscoなども
- 国内ではメルカリやAbemaTVなどは実績がある
- (2年前に調べたきりだから今はもっと多いと思う)

# 通信仕様

https://grpc.io/docs/guides/concepts/

- Unary RPC
もっともシンプルな形式。単一のリクエストに対して単一のレスポンスを行う
- Server streaming RPC
単一のリクエストに対して、連続するデータをレスポンスし続ける。サーバ側のコマンドにより終了する
- Client streaming RPC
Server streamingとは逆で、連続する複数データをリクエストし続ける。クライアント側からの送信が終了したのち、サーバから単一のレスポンスを行う
- Bidirectional streaming RPC
サーバ・クライアント双方から複数のデータの送信を連続で行う