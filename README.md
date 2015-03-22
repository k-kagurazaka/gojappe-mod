# gojappe mod

これは[@3kaido](https://github.com/3kaido)氏のオープンソースRSSリーダ[gojappe](https://github.com/3kaido/gojappe)のクローンリポジトリです。
残念ながら元のリポジトリの更新が途絶えてしまったため、以下の変更を加えた上で自分用にホストしてあります。
単純にforkするのではなく1からリポジトリを作ったのは、開発環境をAndroid Studioに移行したことで変更点が多くなりすぎたからです。

## 変更点

* API level 15以降のみをサポート
* メニュー表示のためにActionBarを追加
* 広告関連のコード削除
* 背景の透明度をスライダーで指定可能に
* フィード長押しメニューにAndroid標準の共有インテントを追加
* 閉鎖したサイトのRSSを削除
