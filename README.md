# ComposeApp: Painel Interativo FCT/UFG

Este é um projeto Kotlin Multiplatform utilizando Compose Multiplatform para desenvolver uma aplicação que roda tanto no Android quanto no Desktop (Windows). A aplicação apresenta uma interface em tela cheia com uma TopBar centralizada, menu lateral (drawer) e um feed de notícias placeholder. No Android, o app inicia em modo kiosk (full-screen imersivo) e só permite sair após a confirmação via senha.

## Funcionalidades

- **Interface Fullscreen:**  
  - No **Desktop**: A janela inicia em tela cheia (undecorated).  
  - No **Android**: O app roda em modo imersivo (oculta status e barra de navegação) e utiliza o Lock Task Mode para um comportamento estilo kiosk.
  
- **Menu Lateral (Drawer):**  
  Contém os seguintes itens:  
  - 🏠 Página Inicial  
  - 🏛️ Conheça o Campus  
  - 🚌 Linha de Ônibus  
  - ⏰ Horário de Aulas  
  - 👥 Equipe FCT/UFG  
  - 🌱 Ações de Extensão  
  - 🔒 Sair (para encerrar o modo kiosk, mediante confirmação de senha)

- **Modo Kiosk (Android):**  
  O app inicia com `startLockTask()` e permanece em tela cheia até que o usuário selecione o item "Sair" no menu e digite a senha correta (padrão: `123456`).

## Estrutura do Projeto

```plaintext
composeApp/
├── build.gradle.kts          # Configuração do Gradle com dependências e plugins
└── src/
    ├── commonMain/
    │   └── kotlin/
    │       └── br/ufg/fct/
    │           ├── MainScreen.kt   # Componentes de UI compartilhados (TopBar, Drawer, etc.)
    │           └── ExitDialog.kt     # Diálogo para saída do modo kiosk
    ├── androidMain/
    │   └── kotlin/
    │       └── br/ufg/fct/android/
    │           └── MainActivity.kt  # Ponto de entrada para o Android
    └── desktopMain/
        └── kotlin/
            └── br/ufg/fct/desktop/
                └── Main.kt          # Ponto de entrada para o Desktop
```

## Pré-requisitos

- **JDK 11 ou superior**
- **Android Studio (para desenvolvimento Android)**
- **Gradle (o projeto utiliza o wrapper do Gradle)**
- **Plugins do Kotlin Multiplatform e Compose Multiplatform**

## Configuração e Execução
1. Clonando o Projeto
```plaintext
git clone https://github.com/seu-usuario/composeApp.git
cd composeApp
```
2. Abrindo no Android Studio

    Abra o Android Studio e selecione File > Open.
    Navegue até a pasta do projeto e abra-o.
    Aguarde a sincronização do Gradle e o download das dependências.

3. Executando a Aplicação
No Android

    Conecte um dispositivo Android ou inicie um emulador.
    Selecione a configuração de execução para Android e execute o app.
    O app iniciará em modo kiosk (full-screen imersivo).
    Para sair:
        Abra o menu lateral e selecione o item Sair.
        Digite a senha 123456 no diálogo de confirmação.

No Desktop (Windows)

    Selecione a configuração de execução para Desktop.
    Execute o app.
    A janela será aberta em modo full-screen (sem bordas e cobrindo toda a tela).

## Customizações

    Interface de Usuário:
    Modifique os arquivos em commonMain/kotlin/br/ufg/fct/ (como MainScreen.kt e ExitDialog.kt) para alterar a UI ou adicionar novas funcionalidades.

    Senha de Saída:
    Altere o valor da senha no componente ExitDialog.kt conforme necessário.

    Funcionalidades Adicionais:
    Implemente a lógica de navegação ou o feed de notícias no espaço reservado.

## Dependências e Recursos

    Kotlin Multiplatform
    Compose Multiplatform
    Jetpack Compose para Android
    Lock Task Mode no Android
